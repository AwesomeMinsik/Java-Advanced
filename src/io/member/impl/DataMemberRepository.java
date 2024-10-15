package io.member.impl;

import io.member.Member;
import io.member.memberRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataMemberRepository implements memberRepository {
    private static final String filePath="temp/members-data.dat";

    private final List<Member> members = new ArrayList<>();
    @Override
    public void add(Member member) {
        try(DataOutputStream dos = new DataOutputStream(new FileOutputStream(filePath,true))) {
            dos.writeUTF(member.getId());
            dos.writeUTF(member.getName());
            dos.writeInt(member.getAge());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Member> findAll() {
        List<Member> members = new ArrayList<>();
        try(DataInputStream dis = new DataInputStream(new FileInputStream(filePath))) {
            while (dis.available()>0){
                members.add(new Member(dis.readUTF(),dis.readUTF(),dis.readInt()));
            }
        return members;
        } catch (FileNotFoundException e) {
            return new ArrayList<>();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
