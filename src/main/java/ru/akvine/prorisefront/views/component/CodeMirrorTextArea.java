package ru.akvine.prorisefront.views.component;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.textfield.TextArea;

@CssImport(value = "./styles/codemirror.css")
public class CodeMirrorTextArea extends TextArea {

    public CodeMirrorTextArea() {
        getElement().setAttribute("class", "codemirror-textarea");
    }

}