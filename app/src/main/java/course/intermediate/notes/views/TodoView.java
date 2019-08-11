package course.intermediate.notes.views;

import android.content.Context;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import course.intermediate.notes.models.Todo;
import intermediate.course.notes.R;

public class TodoView extends ConstraintLayout {

    private CheckBox completeCheckbox;
    private TextView descriptionView;

    public TodoView(Context context) {
        super(context);
    }

    public TodoView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TodoView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void initView(Todo todo) {
        completeCheckbox = findViewById(R.id.completeCheckBox);
        descriptionView = findViewById(R.id.descriptionView);

        completeCheckbox.setChecked(todo.isComplete());
        descriptionView.setText(todo.getDescription());

        if (todo.isComplete()) {
            createStrikeThrough();
        }

        setUpCheckStateListener();

    }

    private void setUpCheckStateListener() {
        completeCheckbox.setOnCheckedChangeListener((button, isChecked) -> {
            if (isChecked) {
                createStrikeThrough();
            } else {
                removeStrikeThrough();
            }
        });
    }

    private void createStrikeThrough() {
        descriptionView.setPaintFlags(descriptionView.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
    }

    private void removeStrikeThrough() {
        descriptionView.setPaintFlags(descriptionView.getPaintFlags() & ~(Paint.STRIKE_THRU_TEXT_FLAG));
    }
}
