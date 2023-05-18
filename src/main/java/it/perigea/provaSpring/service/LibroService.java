package it.perigea.provaSpring.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.perigea.provaSpring.entities.Autore;
import it.perigea.provaSpring.entities.Libro;
import it.perigea.provaSpring.entities.dto.LibroDto;
import it.perigea.provaSpring.entities.dto.LibroMapper;
import it.perigea.provaSpring.repository.AutoreRepository;
import it.perigea.provaSpring.repository.LibroRepository;

@Service
public class LibroService {
	
	@Autowired
	private LibroRepository repository;
	
	@Autowired
	private LibroMapper mapper;

	
	public List<LibroDto> getAllLibri() {
		List<Libro> libri= repository.findAll();
		//List<LibroDto> libriDto= new ArrayList<>();
		//libri.forEach(libro -> libriDto.add(mapper.libroToLibroDto(libro)) );
		List<LibroDto> libriDto=mapper.listaLibriToListaLibriDto(libri);
		return   libriDto;
	}
	
	public LibroDto getByIsbn(String isbn) {
		Libro libro = repository.findByIsbn(isbn).orElseThrow( () -> new EntityNotFoundException("libro con isbn=" + isbn +" non presente nel DataBase."));
		//Ho un oggetto Optional e se null solleva l'eccezione tramite la lamba function altrimenti restituisce l'oggetto contenuto (Libro).
		LibroDto libroDto= mapper.libroToLibroDto( libro );
		return libroDto;
	}
	
	public LibroDto saveOrUpdateLibro(LibroDto libroDaSalvareDto) {
		Optional<Libro> libroUpdate = repository.findByIsbn(libroDaSalvareDto.getIsbn());
		Libro libroDaSalvare=new Libro();
		if ( libroUpdate.isPresent() ){
			libroDaSalvare = mapper.partialUpdate(libroDaSalvareDto, libroUpdate.get() );
		} else {
			libroDaSalvare = mapper.libroDtoToLibro(libroDaSalvareDto);
		}
		repository.save(libroDaSalvare);
		return mapper.libroToLibroDto(libroDaSalvare);	//posso restituire il libro preso in ingresso ma voglio vedere come va la doppia conversione.
	}
	
	@Autowired
	AutoreRepository autoreRepository;
	
	public LibroDto addAutoreToLibro(String isbn, String codFiscale) {
		Libro libro = repository.findByIsbn(isbn).orElseThrow( () -> new EntityNotFoundException("Libro con isbn=" + isbn + " non presente nel DataBase."));
		Autore autore = autoreRepository.findByCodFiscale(codFiscale).orElseThrow(() -> new EntityNotFoundException("Autore con Codice Fiscale=" + codFiscale + " non presente nel DataBase."));
		libro.setAutore(autore);
		LibroDto libroDto= mapper.libroToLibroDto( libro );
		return libroDto;
		}

	@Transactional
	public LibroDto deleteByIsbn(String isbn) {
		Optional<Libro> libroDaEliminareOptional=repository.findByIsbn(isbn);	//al posto di optional e if si può usare orElseThrow() come sopra.
		if (!libroDaEliminareOptional.isPresent() )	
			throw new EntityNotFoundException("libro da eliminare con isbn=" + isbn +" non presente nel DataBase");
		repository.deleteByIsbn(isbn);
		LibroDto libroEliminato=mapper.libroToLibroDto( libroDaEliminareOptional.get() );
		return libroEliminato;
	}
	
	@Transactional
	public LibroDto deleteById(Long id) {
		Optional<Libro> libroDaEliminareOptional=repository.findById(id);	//al posto di optional e if si può usare orElseThrow() come sopra.
		if (!libroDaEliminareOptional.isPresent() )	
			throw new EntityNotFoundException("libro da eliminare con id=" + id +" non presente nel DataBase");
		repository.deleteById(id);
		LibroDto libroEliminato=mapper.libroToLibroDto( libroDaEliminareOptional.get() );
		return libroEliminato;
	}
	
	public LibroDto deleteLibro(LibroDto libroDaEliminareDto) {
		Libro libroDaEliminare=mapper.libroDtoToLibro(libroDaEliminareDto);
		libroDaEliminare.setId(repository.findByIsbn(libroDaEliminareDto.getIsbn()).get().getId());	//potevo direttamente farmi restituire il libro by isbn ed eliminarlo
		repository.delete(libroDaEliminare);
		return mapper.libroToLibroDto(libroDaEliminare);
	}
	
	public List<LibroDto> getByTitolo(String titolo) {
		List<Libro> libri = repository.findAllByTitolo(titolo);
		List<LibroDto> libriDto = mapper.listaLibriToListaLibriDto(libri);
		return libriDto;
	}
	
}
