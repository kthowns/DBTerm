package com.example.myvoca.controller;

import com.example.myvoca.code.ApiResponseCode;
import com.example.myvoca.dto.ApiResponse;
import com.example.myvoca.dto.CreateVocab;
import com.example.myvoca.service.VocabService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api")
public class VocabController{
    private final VocabService vocabService;

    @GetMapping("/vocabs/all")
    public ResponseEntity<?> getVocabs(
            @Valid @RequestParam Integer user_id
    ){
        log.info("HTTP GET /api/vocabs/all?user_id="+user_id);
        return ApiResponse.toResponseEntity(ApiResponseCode.OK,
                vocabService.getVocabs(user_id));
    }

    @GetMapping("/vocabs/detail")
    public ResponseEntity<?> getVocabDetail(
            @Valid @RequestParam Integer vocab_id
    ){
        log.info("HTTP GET /api/vocabs/detail?vocab_id="+vocab_id);
        return ApiResponse.toResponseEntity(ApiResponseCode.OK,
                vocabService.getVocabDetail(vocab_id));
    }

    @PostMapping("/vocabs/{user_id}")
    public ResponseEntity<?> createVocab(
            @Valid @PathVariable Integer user_id,
            @Valid @RequestBody CreateVocab.Request request
    ){
        log.info("HTTP POST /api/vocabs/"+user_id);
        return ApiResponse.toResponseEntity(ApiResponseCode.OK,
                vocabService.createVocab(user_id, request));
    }

    @PatchMapping("/vocabs/{vocab_id}")
    public ResponseEntity<?> editVocab(
            @Valid @PathVariable Integer vocab_id,
            @Valid @RequestBody CreateVocab.Request request
    ){
        log.info("HTTP PATCH /api/vocabs/"+vocab_id);
        return ApiResponse.toResponseEntity(ApiResponseCode.OK,
                vocabService.editVocab(vocab_id, request));
    }

    @DeleteMapping("/vocabs/{vocab_id}")
    public ResponseEntity<?> deleteVocab(
            @Valid @PathVariable Integer vocab_id
    ){
        log.info("HTTP DELETE /api/vocabs/"+vocab_id);
        return ApiResponse.toResponseEntity(ApiResponseCode.OK,
                vocabService.deleteVocab(vocab_id));
    }
}