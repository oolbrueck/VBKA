/**
 * Author: Oliver Olbrück
 */

package de.VBKA.frontend;

import de.VBKA.backend.dao.UserDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;

public class CategoryOverviewSceneController implements Initializable {

    @FXML
    ListView<String> listOfCategories;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        updateCategoryList();
    }
    public int goToMenu(ActionEvent event) {
        new SceneController().switchToDashboard(event);
        return 0;
    }

    public int deleteCategory(ActionEvent event) {

        return 0;
    }

    private void updateCategoryList() {
        listOfCategories.getItems().clear();
        listOfCategories.getItems().addAll(new UserDAO().getCategoriesWithMatcher().stream()
                .map(map -> map.get("NAME") + (String)map.get("MATCHING_WORD")).toList()); //TODO
    }
}
