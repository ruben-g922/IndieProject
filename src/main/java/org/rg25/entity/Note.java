package org.rg25.entity;

import jakarta.persistence.*;
import org.rg25.util.ServletUtil;

import java.util.Objects;

@Entity(name = "Note")
@Table(name = "note")
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    private String title;
    private String content;
    @Column(name = "date_updated")
    private String updated;
    private String created;

    public Note(Note note) {
        id = note.getId();
        user = note.getUser();
        title = note.getTitle();
        content = note.getContent();
        created = note.getCreated();
        updated = note.getUpdated();
    }

    public Note(User user, String title, String content) {
        this();
        this.user = user;
        this.title = title;
        this.content = content;
    }


    public Note() {
        ServletUtil util = new ServletUtil();
        this.updated = util.getDateTime();
        this.created = util.getDateTime();
    }


    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String createdOn) {
        this.created = createdOn;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Note note = (Note) o;
//        return id == note.id && Objects.equals(user, note.user) && Objects.equals(title, note.title) && Objects.equals(content, note.content) && Objects.equals(created, note.created);
//    }


//    @Override
//    public int hashCode() {
//        return Objects.hash(id, user, title, content, created);
//    }
//

    //    @Override
//    public String toString() {
//        return "Note{" +
//                "id=" + id +
//                ", user=" + user +
//                ", title='" + title + '\'' +
//                ", content='" + content + '\'' +
//                ", createdOn='" + created + '\'' +
//                '}';
//    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Note note = (Note) o;
        return id == note.id && Objects.equals(user, note.user) && Objects.equals(title, note.title) && Objects.equals(content, note.content) && Objects.equals(updated, note.updated) && Objects.equals(created, note.created);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, title, content, updated, created);
    }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", user=" + user +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", updated='" + updated + '\'' +
                ", created='" + created + '\'' +
                '}';
    }
}
