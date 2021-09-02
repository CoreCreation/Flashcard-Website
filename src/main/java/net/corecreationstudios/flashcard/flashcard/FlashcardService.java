package net.corecreationstudios.flashcard.flashcard;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//Hooks it up to injected as a service
@Service
public class FlashcardService {

    private final FlashcardRepository flashcardRepository;

    @Autowired
    public FlashcardService(FlashcardRepository flashcardRepository){
        this.flashcardRepository = flashcardRepository;
    }

    public List<Flashcard> getFlashcards(){
		return flashcardRepository.findAll();
	}

    public void addNewFlashcard(Flashcard card){
        Optional<Flashcard> flashcardByFront = flashcardRepository.findFlashcardByFront(card.getFront());

        if(flashcardByFront.isPresent()) {
            throw new IllegalStateException("Flashcard already exists");
        }

        flashcardRepository.save(card);

    }

    @Transactional
    public void updateFlashcardFront(Long id, String front){
        Flashcard card = flashcardRepository.findById(id).orElseThrow(() -> new IllegalStateException("Student with id " + id + " does not exist"));
        if(flashcardRepository.findFlashcardByFront(front).isPresent()){
            throw new IllegalStateException("Card already exists");
        }
        card.setFront(front);
    }

    @Transactional
    public void updateFlashcardBack(Long id, String back){
        Flashcard card = flashcardRepository.findById(id).orElseThrow(() -> new IllegalStateException("Student with id " + id + " does not exist"));
        if(back != card.getBack()){
            card.setBack(back);
        }
    }

    public void deleteFlashcard(Long id){
        boolean exists = flashcardRepository.existsById(id);
        if(!exists) {
            throw new IllegalStateException("Card with id" + id + " does not exist");
        }
        flashcardRepository.deleteById(id);
    }
}
