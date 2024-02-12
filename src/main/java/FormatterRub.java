public class FormatterRub {

    public String correctEnding(double value) {
        value = Math.floor(value);

        value = value % 100;
        if (value > 10 && value < 20) {
            return "рублей";
        } else {
            value = value % 10;
            if (value == 1) {
                return "рубль";
            } else if (value > 1 && value < 5) {
                return "рубля";
            } else {
                return "рублей";
            }
        }
    }
}
