package mk.ukim.finki.wp.lab.web.servlet;

import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;
import mk.ukim.finki.wp.lab.service.ArtistService;
import mk.ukim.finki.wp.lab.service.SongService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SongDetailsServlet", urlPatterns = "/songDetails")
public class SongDetailsServlet extends HttpServlet {

    private final SongService songService;
    private final ArtistService artistService;

    public SongDetailsServlet(SongService songService, ArtistService artistService) {
        this.songService = songService;
        this.artistService = artistService;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String trackId = req.getParameter("trackId");
        Long artistId = Long.parseLong(req.getParameter("artistId"));
        Song song = songService.findByTrackId(trackId);
        Artist artist = artistService.findById(artistId);

        songService.addArtistToSong(artist, song);
        req.setAttribute("song", song);
        req.getRequestDispatcher("/WEB-INF/templates/songDetails.html").forward(req, resp);
    }
}