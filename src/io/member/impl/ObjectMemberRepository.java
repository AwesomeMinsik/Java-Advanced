package io.member.impl;

import io.member.Member;
import io.member.memberRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ObjectMemberRepository implements memberRepository {

    private static final String filePath="temp/members-object.dat";

    @Override
    public void add(Member member) {
        List<Member> members = findAll();
        members.add(member);
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(members);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Member> findAll() {
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            Object findObject = ois.readObject();
            List<Member> list = (List<Member>) findObject;
            return list;
        } catch (FileNotFoundException e) {
            return new ArrayList<>();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
