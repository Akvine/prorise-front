package ru.akvine.prorisefront.views;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.router.Route;
import ru.akvine.prorisefront.views.component.CodeMirrorTextArea;

@Route("spring-task")
@CssImport(value = "./styles/code-editor.css", themeFor = "vaadin-text-area")
public class SpringTaskView extends VerticalLayout {
    private boolean darkMode = false;

    private TextArea taskTextArea = new TextArea("Task");
    private TextArea codeTextArea = new TextArea("Code");
    private Button submitButton = new Button("Submit");

    public SpringTaskView() {
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);

        H1 title = new H1("Spring Framework Task");

        // Set up task text area
        taskTextArea.setValue("Write a controller class that handles GET requests to /hello and returns a " +
                "String response with the message \"Hello, World!\"");
        taskTextArea.setWidth("50%");
        taskTextArea.setHeight("200px");
        taskTextArea.setReadOnly(true);

        // Set up code text area
        codeTextArea.setWidth("50%");
        codeTextArea.setHeight("400px");
        codeTextArea.getStyle().set("white-space", "pre-wrap");
        codeTextArea.getStyle().set("font-family", "monospace");
        codeTextArea.getStyle().set("font-size", "14px");
        codeTextArea.addClassName("text-area");

//        codeTextArea.addKeyPressListener(new ShortcutListener("Bracket Shortcut", Key.ARROW_LEFT, ModifierKey.CTRL) {
//            @Override
//            public void handleAction(Object sender, Object target) {
//                String text = textField.getValue();
//                int cursorPosition = textField.getCursorPosition();
//                StringBuilder builder = new StringBuilder(text);
//                builder.insert(cursorPosition, "{}");
//                textField.setValue(builder.toString());
//                textField.setCursorPosition(cursorPosition + 1);
//            }
//        });

        add(new CodeMirrorTextArea());

        Button toggleThemeButton = new Button("Toggle Theme");
        toggleThemeButton.addClickListener(e -> {
            if (darkMode) {
                UI.getCurrent().getPage().executeJs("document.documentElement.setAttribute('theme', 'light');");
                darkMode = false;
            } else {
                UI.getCurrent().getPage().executeJs("document.documentElement.setAttribute('theme', 'dark');");
                darkMode = true;
            }
        });

        // Добавляем кнопку на страницу
        add(toggleThemeButton);

        // Set up submit button
        submitButton.addClickListener(e -> {
            String code = codeTextArea.getValue();
            boolean isCorrect = checkCode(code);
            if (isCorrect) {
                Notification.show("Congratulations, your code is correct!", 3000, Notification.Position.BOTTOM_CENTER);
            } else {
                Notification.show("Sorry, your code is incorrect.", 3000, Notification.Position.BOTTOM_CENTER);
            }
        });
        submitButton.setWidth("100px");

        // Add components to the layout
        add(title, taskTextArea, codeTextArea, submitButton);
    }

    private boolean checkCode(String code) {
        // This is where you would check if the code is correct
        // For the sake of simplicity, we'll just return true
        return true;
    }
}