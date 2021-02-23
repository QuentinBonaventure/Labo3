package be.technifutur.Labo3.model.entities;

public enum Category {
    Alimentaire(1), Packaging(2);

    int nbCategorie;
    Category(int nbCategorie){
        this.nbCategorie =nbCategorie;
    }
}
