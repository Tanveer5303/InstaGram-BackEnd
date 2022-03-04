package com.bilal.instaclonebackend.service.impl;

import com.bilal.instaclonebackend.dto.PostDTO;
import com.bilal.instaclonebackend.dto.UserDTO;
import com.bilal.instaclonebackend.model.Post;
import com.bilal.instaclonebackend.model.User;
import com.bilal.instaclonebackend.repository.PostRepository;
import com.bilal.instaclonebackend.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public List<PostDTO> getAllPost() {

        return postRepository.findAll()
                .stream()
                .map(this::convertEntityToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PostDTO addPost(PostDTO postDTO) {
        Post post = convertDTOtoEntity(postDTO);
        Post postSaved = postRepository.save(post);

        PostDTO postDTOReturned = convertEntityToDTO(postSaved);

        return postDTOReturned;
    }

    @Override
    public PostDTO findPost(long postId)
    {
        Post post = postRepository.findById(postId).orElseThrow(
                ()-> new RuntimeException("Post Not Found")
        );

        PostDTO postDTO = convertEntityToDTO(post);

        return postDTO;
    }

    @Override
    public PostDTO deletePost(long postId) {
        Post posttobeDeleted = postRepository.findById(postId).orElseThrow(
                ()-> new RuntimeException("Post not found")
        );
        postRepository.delete(posttobeDeleted);

        PostDTO postDTO = convertEntityToDTO(posttobeDeleted);

        return postDTO;
    }


    private PostDTO convertEntityToDTO(Post post){
        return PostDTO.builder()
                .username(post.getUser().getUserName())
                .uId(post.getUser().getUId())
                .description(post.getDescription())
                .image_url(post.getImage_url())
                .time(post.getTime())
                .user(post.getUser())
                .comments(post.getComments())
                .reactions(post.getReactions())
                .build();
    }

    private Post convertDTOtoEntity(PostDTO postDTO) {
        return Post.builder()
                .description(postDTO.getDescription())
                .image_url(postDTO.getImage_url())
                .time(postDTO.getTime())
                .user(postDTO.getUser())
                .comments(postDTO.getComments())
                .reactions(postDTO.getReactions())
                .build();
    }

}
