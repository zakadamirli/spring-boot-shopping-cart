//package com.dreamshops.controller;
//
//import com.dreamshops.service.image.AWS3Service;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.io.ByteArrayResource;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//
//@RestController
//@RequestMapping("/amazon-s3")
//public class AWS3Controller {
//
//    @Autowired
//    private AWS3Service service;
//
//    @PostMapping("/upload-image")
//    public ResponseEntity<String> uploadFile(@RequestParam(value = "file") MultipartFile file) {
//        return new ResponseEntity<>(service.uploadFile(file), HttpStatus.OK);
//    }
//
//    @GetMapping("/download-file/{fileName}")
//    public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable String fileName) {
//        byte[] data = service.downloadFile(fileName);
//        ByteArrayResource resource = new ByteArrayResource(data);
//        return ResponseEntity
//                .ok()
//                .contentLength(data.length)
//                .header("Content-type", "application/octet-stream")
//                .header("Content-disposition", "attachment; filename=\"" + fileName + "\"")
//                .body(resource);
//    }
//
//    @GetMapping("/show-image/{fileName}")
//    public ResponseEntity<String> getFileUrl(@PathVariable String fileName) {
//        String fileUrl = service.getFileUrl(fileName);
//        return ResponseEntity.ok(fileUrl);
//    }
//
//    @DeleteMapping("/delete-image/{fileName}")
//    public ResponseEntity<String> deleteFile(@PathVariable String fileName) {
//        return new ResponseEntity<>(service.deleteFile(fileName), HttpStatus.OK);
//    }
//}
