package com.bilal.instaclonebackend.service.impl;

import com.bilal.instaclonebackend.dto.ReactionDTO;
import com.bilal.instaclonebackend.dto.UserDTO;
import com.bilal.instaclonebackend.model.Reaction;
import com.bilal.instaclonebackend.model.User;
import com.bilal.instaclonebackend.repository.ReactionRepository;
import com.bilal.instaclonebackend.service.ReactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class ReactionServiceImpl implements ReactionService {
   @Autowired
    ReactionRepository reactionRepository;

    @Override
    public List<ReactionDTO> getAllReaction() {
        return reactionRepository.findAll()
                .stream()
                .map(this::convertEntityToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ReactionDTO addReaction(Reaction reaction) {
        Reaction reactionSaved = reactionRepository.save(reaction);

        ReactionDTO reactionDTO = convertEntityToDTO(reactionSaved);

        return reactionDTO;
    }

    @Override
    public ReactionDTO findReaction(long reactionId) {

        Reaction reaction = reactionRepository.findById(reactionId).orElseThrow(
                ()-> new RuntimeException("Reaction Not found")
        );

        ReactionDTO reactionDTO = convertEntityToDTO(reaction);

        return reactionDTO;
    }

    @Override
    public ReactionDTO deleteReaction(long reactionId) {
        Reaction reactiontobeDeleted = reactionRepository.findById(reactionId).orElseThrow(
                ()-> new RuntimeException("reaction not found")
        );

        ReactionDTO reactionDTO = convertEntityToDTO(reactiontobeDeleted);

        return reactionDTO;
    }

    private ReactionDTO convertEntityToDTO(Reaction reaction){
        return ReactionDTO.builder()
                .Reactor(reaction.getUser().getUserName())
                .PostId(reaction.getPost().getPostId())
                .Reaction(reaction.getReaction())
                .Time(reaction.getTime())
                .build();
    }
}
