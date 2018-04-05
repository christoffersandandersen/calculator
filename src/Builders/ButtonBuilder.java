package Builders;

import javafx.scene.control.Button;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class ButtonBuilder {

    public ArrayList getNumericButtons(int from, int to) {
        ArrayList<Button> buttons = new ArrayList<>();
        StringBuilder sb;

        for (; from <= to; from++) {
            sb = new StringBuilder();
            String s = sb.append(from).toString();
            buttons.add(new Button(s));
        }

        return buttons;
    }

    public HashMap<String, Button> getOperators() {
        HashMap<String, Button> buttons = new HashMap<>();

        Button add = new Button("+");
        add.setMinSize(40, 40);
        buttons.put("+", add);

        
        Button sub = new Button("-");
        sub.setMinSize(40, 40);
        buttons.put("-", sub);


        Button mult = new Button("*");
        mult.setMinSize(40, 40);
        buttons.put("*", mult);

        Button div = new Button("/");
        div.setMinSize(40, 40);
        buttons.put("/", div);
                              
        return buttons;
    }
}
