package com.example.shop.member;

import com.example.shop.member.dto.MemberCreateRequest;
import com.example.shop.member.dto.MemberUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Member;
import java.net.URI;
import java.util.List;

//@Controller
//@ResponseBody
@RestController // @Controller + @ResponseBody
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService; //필요한 의존성을 final 키워드를 사용해 추가

    @PostMapping
    public ResponseEntity<?> createMember(@RequestBody MemberCreateRequest request) {
        Long memberId = memberService.createMember(request);
        return ResponseEntity.created(URI.create("/members/" + memberId)).build();
    }

    @GetMapping
    public ResponseEntity<List<com.example.shop.member.Member>> getAllMembers() {
        //Service
        List<com.example.shop.member.Member> members = memberService.getAllMembers();
        return ResponseEntity.ok(members);
    }


    @GetMapping("/{memberId}")
    public ResponseEntity<Member> getMember(@PathVariable Long memberId) {
        Member member = (Member) memberService.getMemberById(memberId);
        return ResponseEntity.ok(member);
    }

    @PatchMapping("/{memberId}")
    public ResponseEntity<Void> updateMember(
            @PathVariable Long memberId,
            @RequestBody MemberUpdateRequest request) {
        memberService.updateMember(memberId, request);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{memberId}")
    public ResponseEntity<Void> deleteMember(@PathVariable Long memberId) {
        memberService.deleteMember(memberId);
        return ResponseEntity.noContent().build();  // 204 no content
    }
}
