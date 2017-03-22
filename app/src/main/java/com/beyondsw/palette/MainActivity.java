package com.beyondsw.palette;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private View mUndoView;
    private View mRedoView;
    private View mPenView;
    private View mEraserView;
    private View mClearView;
    private PaletteView mPaletteView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPaletteView = (PaletteView)findViewById(R.id.palette);

        mUndoView = findViewById(R.id.undo);
        mRedoView = findViewById(R.id.redo);
        mPenView = findViewById(R.id.pen);
        mEraserView = findViewById(R.id.eraser);
        mClearView = findViewById(R.id.clear);

        mUndoView.setOnClickListener(this);
        mRedoView.setOnClickListener(this);
        mPenView.setOnClickListener(this);
        mEraserView.setOnClickListener(this);
        mClearView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.undo:
                mPaletteView.undo();
                break;
            case R.id.redo:
                mPaletteView.redo();
                break;
            case R.id.pen:
                break;
            case R.id.eraser:
                if (mPaletteView.getMode() == PaletteView.Mode.DRAW) {
                    mPaletteView.setMode(PaletteView.Mode.ERASER);
                } else {
                    mPaletteView.setMode(PaletteView.Mode.DRAW);
                }
                break;
            case R.id.clear:
                mPaletteView.clear();
                break;
        }
    }
}
