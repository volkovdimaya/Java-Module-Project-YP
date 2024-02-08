public class FormatterRub {

    public String correctEnding(double value)
    {
       double d = Math.floor(value);
       if(d == 1)
       {
           return "рубль";
       }
       else if(d > 1 && d < 5)
       {
           return "рубля";
       }
       else
       {
           return "рублей";
       }

    }
}
