package io.member.impl;

import io.member.Member;
import io.member.memberRepository;
import io.start.Buffered;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import static java.nio.charset.StandardCharsets.*;

public class FileMemberRepository implements memberRepository {

    private static final String filePath="temp/members-txt.dat";
       private static final String DELIMITER= ",";
    @Override
    public void add(Member member){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, UTF_8, true))) {
        bw.write(member.getId() + DELIMITER + member.getName()+DELIMITER + member.getAge());
        bw.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Member> findAll() {
        List<Member> members = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(filePath,UTF_8))){
            String line;
            while ((line = br.readLine()) != null){
                String[] memberData = line.split(DELIMITER);
                members.add(new Member(memberData[0], memberData[1], Integer.valueOf(memberData[2])));
            }

        }catch (FileNotFoundException e){
            new ArrayList<>();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        return members;
    }
}
