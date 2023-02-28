package my.com.ktworld.member.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import my.com.ktworld.common.ApiResponse;
import my.com.ktworld.member.dto.request.MemberForm;
import my.com.ktworld.member.dto.request.MemberSearchCondition;
import my.com.ktworld.member.dto.response.MemberDto;
import my.com.ktworld.member.service.MemberService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/members")
@RestController
public class MemberController {

    private final MemberService memberService;

    @PostMapping
    public ResponseEntity<?> createMember(@RequestBody MemberForm memberForm) {
        memberService.createMember(memberForm);
//        ApiResponse.createSuccessNoData();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<ApiResponse<?>> updateMember(@RequestBody MemberForm memberForm) {
        memberService.updateMember(memberForm);
        //ApiResponse.createSuccessNoData()
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{member_id}")
    public ResponseEntity<ApiResponse<MemberDto>> selectMember(@PathVariable(value = "member_id") long memberId) {
        return new ResponseEntity<>(memberService.selectMember(memberId), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<ApiResponse<Page<MemberDto>>> searchMembers(MemberSearchCondition condition, Pageable pageable) {
        return new ResponseEntity<>(memberService.searchMembers(condition, pageable), HttpStatus.OK);
    }

}
