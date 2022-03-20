package com.tanveer.instaclonebackend.service.impl;


import com.tanveer.instaclonebackend.dto.ReactionDTO;
import com.tanveer.instaclonebackend.model.Post;
import com.tanveer.instaclonebackend.model.Reaction;
import com.tanveer.instaclonebackend.repository.ReactionRepository;
import com.tanveer.instaclonebackend.service.ReactionService;
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
    public ReactionDTO addReaction(ReactionDTO reactionDTO) {
        Reaction reaction = convertDTOtoEntity(reactionDTO);
        Reaction reactionSaved = reactionRepository.save(reaction);
        ReactionDTO reactionDTOReturned = convertEntityToDTO(reactionSaved);

        return reactionDTOReturned;
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

    @Override
    public ReactionDTO updateReaction(Long reactionId, ReactionDTO reactionDTO) {
        reactionRepository.findById(reactionId).orElseThrow(
                ()-> new RuntimeException("reaction not found")
        );
        Reaction updateReaction = convertDTOtoEntity(reactionDTO);
        updateReaction.setReactionId(reactionId);
        Reaction reactionSaved =  reactionRepository.save(updateReaction);

        return convertEntityToDTO(reactionSaved);
    }

    private ReactionDTO convertEntityToDTO(Reaction reaction){
        return ReactionDTO.builder()
                .Reactor(reaction.getUser().getUserName())
                .PostId(reaction.getPost().getPostId())
                .Reaction(reaction.getReaction())
                .Time(reaction.getTime())
                .user(reaction.getUser())
                .post(reaction.getPost())
                .uId(reaction.getUser().getUId())
                .build();
    }
    private Reaction convertDTOtoEntity(ReactionDTO reactionDTO) {
        return Reaction.builder()
                .user(reactionDTO.getUser())
                .post(reactionDTO.getPost())
                .reaction(reactionDTO.getReaction())
                .time(reactionDTO.getTime())
                .build();
    }
}
