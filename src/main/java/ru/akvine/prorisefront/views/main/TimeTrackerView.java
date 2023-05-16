package ru.akvine.prorisefront.views.main;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import ru.akvine.prorisefront.components.Header;

import java.time.Duration;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

@Route("time-tracker")
public class TimeTrackerView extends VerticalLayout {

    private Map<String, LocalTime> timeMap = new HashMap<>();
    private Label sectionLabel = new Label("Select a section to start tracking time: ");
    private ComboBox<String> sectionComboBox = new ComboBox<>();
    private Button startButton = new Button("Start");
    private Button stopButton = new Button("Stop");
    private Grid<SectionTime> timeGrid = new Grid<>(SectionTime.class);

    public TimeTrackerView() {
        add(new Header());
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);

        H1 title = new H1("Трекинг времени");

        sectionComboBox.setItems("Design", "Development", "Testing", "Documentation");
        sectionComboBox.addValueChangeListener(e -> {
            if (timeMap.containsKey(e.getValue())) {
                LocalTime time = timeMap.get(e.getValue());
                String formattedTime = formatTime(time);
                timeGrid.setItems(new SectionTime(e.getValue(), formattedTime));
            } else {
                timeGrid.setItems(new SectionTime(e.getValue(), "00:00:00"));
            }
        });

        startButton.addClickListener(e -> {
            String section = sectionComboBox.getValue();
            if (section != null) {
                timeMap.put(section, LocalTime.now());
                startButton.setEnabled(false);
                stopButton.setEnabled(true);
            }
        });
        startButton.setEnabled(false);

        stopButton.addClickListener(e -> {
            String section = sectionComboBox.getValue();
            if (section != null) {
                LocalTime startTime = timeMap.get(section);
                LocalTime endTime = LocalTime.now();
                Duration duration = Duration.between(startTime, endTime);
                String formattedTime = formatDuration(duration);
                timeMap.put(section, endTime);
                timeGrid.setItems(new SectionTime(section, formattedTime));
                startButton.setEnabled(true);
                stopButton.setEnabled(false);
            }
        });
        stopButton.setEnabled(false);

        HorizontalLayout sectionLayout = new HorizontalLayout(sectionLabel, sectionComboBox);
        sectionLayout.setSpacing(true);

        HorizontalLayout buttonLayout = new HorizontalLayout(startButton, stopButton);
        buttonLayout.setSpacing(true);

        timeGrid.setColumns("section", "time");
        timeGrid.setSizeFull();

        add(title, sectionLayout, buttonLayout, timeGrid);
    }

    private String formatDuration(Duration duration) {
        long hours = duration.toHours();
        long minutes = duration.toMinutes() % 60;
        long seconds = duration.getSeconds() % 60;
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }

    private String formatTime(LocalTime time) {
        return String.format("%02d:%02d:%02d", time.getHour(), time.getMinute(), time.getSecond());
    }

    private class SectionTime {
        private String section;
        private String time;

        public SectionTime(String section, String time) {
            this.section = section;
            this.time = time;
        }

        public String getSection() {
            return section;
        }

        public void setSection(String section) {
            this.section = section;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }
    }
}