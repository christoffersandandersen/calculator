package Builders;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.Collection;
import java.util.List;

public class CellBuilder {


   public HBox getButtonRow(List<Button> buttons, int from, int to){


       HBox row = new HBox(10);

       for(; from <= to; from++){
           row.getChildren().add(buttons.get(from));
           buttons.get(from).setMinSize(40, 40);
       }


       return row;
   }

   public VBox getButtonColumn(Collection<Button> buttons){
       VBox box = new VBox(10);

       for(Button b: buttons)
           box.getChildren().add(b);

       return box;
   }


}
