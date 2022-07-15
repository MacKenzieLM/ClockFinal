package clock;


/*
* This was a pre-coded class designed for assignment.  
*/
public class Clock {
    
    public static void main(String[] args) {
        Model model = new Model();
        View view = new View(model);
        model.addObserver(view);
        Controller controller = new Controller(model, view);
    }
    
}
