package com.tanveer.instaclonebackend.service.impl;

import com.tanveer.instaclonebackend.dto.CommentDTO;
import  com.tanveer.instaclonebackend.model.Comment;
import com.tanveer.instaclonebackend.model.Post;
import  com.tanveer.instaclonebackend.repository.CommentRepository;
import com.tanveer.instaclonebackend.repository.PostRepository;
import  com.tanveer.instaclonebackend.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public List<CommentDTO> getAllComments(Long uId, Long postId) {

        return commentRepository.findAll()
                .stream()
                .map(this::convertEntityToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CommentDTO addComment(Long uId, Long postId, CommentDTO commentDTO) {
        //we dont have id at the time we receive data so we will take it in the form of DTO
        //set uId,postId,User and Post manually, (user and post finding it by postId and uId)
        Comment comment = convertDTOtoEntity(commentDTO);
        Comment commentSaved = commentRepository.save(comment);
        CommentDTO commentDTOReturned = convertEntityToDTO(commentSaved);
        return commentDTO;
    }

    @Override
    public CommentDTO findComment(Long uId, Long postId, long commentId) {
        //set uId,postId,User and Post manually, (user and post finding it by postId and uId)
        Comment comment = commentRepository.findById(commentId).orElseThrow(
                ()-> new RuntimeException("Comment not found")
        );
        CommentDTO commentDTO = convertEntityToDTO(comment);

        return commentDTO;
    }

    @Override
    public CommentDTO deleteComment(long commentId) {

        Comment commenttobeDeleted = commentRepository.findById(commentId).orElseThrow(
                ()-> new RuntimeException("comment not found")
        );
        commentRepository.delete(commenttobeDeleted);

        CommentDTO commentDTO = convertEntityToDTO(commenttobeDeleted);
        return commentDTO;
    }

    @Override
    public CommentDTO updateComment(Long uId, Long postId, Long commentId, CommentDTO commentDTO) {
        //set uId,postId,User and Post manually, (user and post finding it by postId and uId)
        Post post = postRepository.findById(postId).orElseThrow(
                ()-> new RuntimeException("Post Not Exist")
        );

        commentRepository.findById(commentId).orElseThrow(
                ()-> new RuntimeException("Comment not found")
        );

        Comment updateComment = convertDTOtoEntity(commentDTO);

        updateComment.setCommentId(commentId);
        Comment commentSaved =  commentRepository.save(updateComment);

        return convertEntityToDTO(commentSaved);
    }

    //have to take care of uId and Pid in respective service implementation
    private CommentDTO convertEntityToDTO(Comment comment){
        return CommentDTO.builder()
                .comment(comment.getComment())
                .time(comment.getTime())
                .uId(comment.getUser().getUId())
                //set User and Post manually finding it by postId and uId
                .PostId(comment.getPost().getPostId())
                .build();
    }

    private Comment convertDTOtoEntity(CommentDTO commentDTO) {
        return Comment.builder()
               //set uId,postId,User and Post manually, (user and post finding it by postId and uId)
                .comment(commentDTO.getComment())
                .time(commentDTO.getTime())
                .build();
    }

}
