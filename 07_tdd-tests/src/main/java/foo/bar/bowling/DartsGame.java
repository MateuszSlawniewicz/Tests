package foo.bar.bowling;

public class DartsGame {

    private int score;
    //todo

    public DartsGame() {
        this.score = 501;
    }

    public int getScore() {
        return score;
    }





    public int hit(int point, TypeOfField field) {
        if (!field.equals(TypeOfField.BULLSEYE)) {
            score = score - point * getFieldValue(field);
        } else {
            score = score - getFieldValue(field);
        }
        return score;


    }


    private int getFieldValue(TypeOfField field) {
        if (field.equals(TypeOfField.SINGLE)) {
            return 1;
        }
        if (field.equals(TypeOfField.DOUBLE)) {
            return 2;
        }
        if (field.equals(TypeOfField.TRIPLE)) {
            return 3;
        }
        return 50;
    }
}