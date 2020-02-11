package cz.databazista.spring5webapp.bootstrap;

import cz.databazista.spring5webapp.domain.Author;
import cz.databazista.spring5webapp.domain.Book;
import cz.databazista.spring5webapp.domain.Publisher;
import cz.databazista.spring5webapp.repositories.AuthorRepository;
import cz.databazista.spring5webapp.repositories.BookRepository;
import cz.databazista.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;

    }

    @Override
    public void run(String... args) throws Exception {

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "123123");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development wihout EJB", "3994813613");

        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);
        authorRepository.save(rod);
        bookRepository.save(noEJB);


        Publisher pub = new Publisher();
        pub.setPublisherAddress("Klapkova 1");
        pub.setPublisherName("MF Dnes");
        publisherRepository.save(pub);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Number of publishers: " + publisherRepository.count());

    }
}