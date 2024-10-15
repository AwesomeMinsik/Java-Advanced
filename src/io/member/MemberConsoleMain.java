package io.member;

import io.member.impl.DataMemberRepository;
import io.member.impl.FileMemberRepository;
import io.member.impl.MemoryMemberRepository;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class MemberConsoleMain {
    //    private static final MemoryMemberRepository repository = new MemoryMemberRepository();
//    private static final memberRepository repository = new FileMemberRepository();
    private static final memberRepository repository = new DataMemberRepository();
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("| 1. 회원 등록 | 2. 회원 목록 조회 | 3. 종료 |");
            System.out.println("선택 :");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice){
                case 1:
                    resisterMember(scanner);
                    //등록
                    break;
                case 2:
                    displayMembers();
                    //조회
                    break;
                case 3:
                    System.out.println("프로그램을 종료합니다.");
                    return;
                default:
                    System.out.println("입력오류");
            }
        }
    }


    private static void resisterMember(Scanner scanner) throws IOException {
        System.out.println("Id 입력:");
        String id = scanner.nextLine();
        System.out.println("name 입력:");
        String name = scanner.nextLine();
        System.out.println("Age 입력:");
        int age = scanner.nextInt();
        scanner.nextLine();
        Member newMember = new Member(id,name,age);

        repository.add(newMember);
        System.out.println("등록되었습니다.");
    }
    private static void displayMembers() {
        List<Member> members = repository.findAll();
        System.out.println("회원목록");
        for (Member member : members) {
            System.out.printf("[ID: %s , NAME: %s , AGE: %d]\n",member.getId(),member.getName(),member.getAge());
        }
    }
}

