package com.tanveer.instaclonebackend.service.impl;

import com.tanveer.instaclonebackend.dto.PostDTO;
import com.tanveer.instaclonebackend.model.Post;
import com.tanveer.instaclonebackend.repository.PostRepository;
import com.tanveer.instaclonebackend.repository.UserRepository;
import com.tanveer.instaclonebackend.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public List<PostDTO> getAllPost(Long uId) {

        return postRepository.findAll()
                .stream()
                .map(this::convertEntityToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PostDTO addPost(Long uId, PostDTO postDTO) {
        Post post = convertDTOtoEntity(postDTO);
        //User user = userRepository.findById(uId).orElseThrow(
          //      ()->new RuntimeException("user not found")
        //);
        //post.setUser(user);
        Post postSaved = postRepository.save(post);

        PostDTO postDTOReturned = convertEntityToDTO(postSaved);

        return postDTOReturned;
    }

    @Override
    public PostDTO findPost(Long uId, long postId)
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

    @Override
    public PostDTO updatePost(Long uId, Long postId, PostDTO postDTO) {
      postRepository.findById(postId).orElseThrow(
                ()-> new RuntimeException("User not found")
        );
        Post updatePost = convertDTOtoEntity(postDTO);
        updatePost.setPostId(postId);
        Post postSaved =  postRepository.save(updatePost);

        return convertEntityToDTO(postSaved);
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
