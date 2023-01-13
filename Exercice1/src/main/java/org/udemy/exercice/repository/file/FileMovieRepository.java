package org.udemy.exercice.repository.file;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.udemy.exercice.entity.Movie;
import org.udemy.exercice.repository.MovieRepositoryInterface;

import java.io.*;
import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.List;

@Repository
public class FileMovieRepository implements MovieRepositoryInterface {


    //File ficherBackup;
    @Value("${movie.fichier.location}")
    File ficherBackup;


    public File getFicherBackup() {
        return ficherBackup;
    }

    public void setFicherBackup(File ficherBackup) {
        this.ficherBackup = ficherBackup;
    }

    @Override
    public List<Movie> list() {

        List<Movie> movies=new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader(ficherBackup))) {
            for(String line; (line = br.readLine()) != null; ) {
                final Movie movie=new Movie();
                final String[] titreEtGenre = line.split("\\;");
                movie.setNumberId(titreEtGenre[0]);
                movie.setTitle(titreEtGenre[1]);
                movie.setGenre(titreEtGenre[2]);
                movies.add(movie);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return movies;
    }

    public void add(Movie movie) {

        FileWriter writer;
        List<Movie> temp = list();

        //String lst = list().stream().map(Movie::getNumberId).max(char::compare).orElse("");

        // Non fonctionnel : long lastId=list().stream().map(Movie::getNumberId).max(Long::compare).orElse(0L);
        String lastId= String.valueOf(Integer.parseInt((temp.get(temp.size()-1)).getNumberId())+1);
        try{
            //writer=new FileWriter("C:\\Users\\duparc\\Documents\\Projets\\Temp\\movies.txt",true);
            writer = new FileWriter(ficherBackup, true);
            writer.write(lastId+";"+movie.getTitle()+";"+movie.getGenre()+"\n");
            writer.close();
            System.out.println("[INFO] - {FileMovieRepository} - Le film n°:"+lastId+"-"+movie.getTitle()+" de type "+movie.getGenre()+" a bien été ajouté");
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public Movie getDetail(String number) {
        Movie movie=new Movie();
        int i = 1;

        System.out.println("[INFO] - Numéro demandé : "+number);

        try(BufferedReader br = new BufferedReader(new FileReader(ficherBackup))) {
            for(String line; (line = br.readLine()) != null; ) {
                final String[] titreEtGenre = line.split("\\;");
                if (i == Integer.parseInt(number)) {
                    System.out.println("[INFO] - Numéro trouvé : "+i);
                    movie.setNumberId(titreEtGenre[0]);
                    movie.setTitle(titreEtGenre[1]);
                    movie.setGenre(titreEtGenre[2]);
                    break;
                }
                else i++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return movie;

    }
}
