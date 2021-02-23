package be.technifutur.Labo3.model.entities.enums;

public enum Categorie {
    Entrecote(1), Poitrine(2), Hachis(3), Saucisse(4);

    int nbCategorie;
    Categorie(int nbCategorie){
        this.nbCategorie =nbCategorie;
    }
}
