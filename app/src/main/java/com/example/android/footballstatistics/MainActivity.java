package com.example.android.footballstatistics;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    float dpOffsetFromCenter = 6;    //the distance in dp between bars in center
    float maxWidthInDp = 160;         //the total maximum width value in dp allowed for the bars in order to fit the screen;

    /*
    //get the size of the screen
    DisplayMetrics metrics = this.getResources().getDisplayMetrics();
    int width = metrics.widthPixels;
    int height = metrics.heightPixels;
     */

    //To avoid the landscape mode I suggest to use *android:screenOrientation = "portrait"* in the *AndroidManifest.xml* file

    //---------------------------------------------Variable declarations------------------------------------------
    //Score variables
    float scoreLeft = 0;              //the score for the left Team
    float scoreRight = 0;             //the score for the right Team
    float maxScore = scoreLeft + scoreRight;

    //Total shots variables
    float tShotseLeft = 0;              //the total shots for the left Team
    float tShotseRight = 0;             //the total shots for the right Team
    float maxTshots = tShotseLeft + tShotseRight;

    //Shots on target
    float targetShotseLeft = 0;              //the shots on target for the left Team
    float targetShotseRight = 0;             //the shots on target for the right Team
    float maxTargetshots = targetShotseLeft + targetShotseRight;

    //Possession variables
    float possessionLeft = 0;              //the score for the left Team
    float possessionRight = 0;             //the score for the right Team
    //float possessionRightZ = 0;
    float maxPossession = possessionLeft + possessionRight;

    //Yellow cards variables
    float ycardsLeft = 0;              //the score for the left Team
    float ycardsRight = 0;             //the score for the right Team
    float maxYcards = ycardsLeft + ycardsRight;

    //Red cards variables
    float rcardsLeft = 0;              //the score for the left Team
    float rcardsRight = 0;             //the score for the right Team
    float maxRcards = rcardsLeft + rcardsRight;


    private static final String STATE_COUNTER = "counter";
    //
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Check whether we're recreating a previously destroyed instance
        if (savedInstanceState != null) {
            // Restore value of members from saved state
            onRestoreInstanceState(savedInstanceState);
        } else {
            // Probably initialize members with default values for a new instance
            initCondition();
        }



    }//EOF onCreate************************************************************************************************************************************************

    //---------------------------------Save the current state of variables----------------------------------//
    //http://www.techotopia.com/index.php/Saving_and_Restoring_the_User_Interface_State_of_an_Android_Activity
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //Log.i("de salvat", "onSaveInstanceState");
        /*
        //-----------------------------------Save the text-----------------------------------------//
        //Score
        saveText(outState, R.id.score_left_view, "score_left_view");
        saveText(outState, R.id.score_right_view, "score_right_view");
        //Total shots
        saveText(outState, R.id.tshots_left_view, "tshots_left_view");
        saveText(outState, R.id.tshots_right_view, "tshots_right_view");
        //Shots on target
        saveText(outState, R.id.targetshots_left_view, "targetshots_left_view");
        saveText(outState, R.id.targetshots_right_view, "targetshots_right_view");
        //Possession
        saveText(outState, R.id.possession_left_view, "possession_left_view");
        saveText(outState, R.id.possession_right_view, "possession_right_view");
        //Yellow cards
        saveText(outState, R.id.ycards_left_view, "ycards_left_view");
        saveText(outState, R.id.ycards_right_view, "ycards_right_view");
        //Red cards
        saveText(outState, R.id.rcards_left_view, "rcards_left_view");
        saveText(outState, R.id.rcards_right_view, "rcards_right_view");

        //------------------------------Save the bars-------------------------------------------//
        saveBar(outState, R.id.score_bar_left, "score_bar_left");
        */
        saveText(outState, R.id.rcards_right_view, "savedText");
    }

    protected void onRestoreInstanceState(Bundle savedState) {
        // Log.i("de salvat", "onRestoreInstanceState");
        /*
        //-----------------------------------Save the text-----------------------------------------//
        //Score
        restoreText(savedState, R.id.score_left_view, "score_left_view");
        restoreText(savedState, R.id.score_right_view, "score_right_view");
        //Total shots
        restoreText(savedState, R.id.tshots_left_view, "tshots_left_view");
        restoreText(savedState, R.id.tshots_right_view, "tshots_right_view");
        //Shots on target
        restoreText(savedState, R.id.targetshots_left_view, "targetshots_left_view");
        restoreText(savedState, R.id.targetshots_right_view, "targetshots_right_view");
        //Possession
        restoreText(savedState, R.id.possession_left_view, "possession_left_view");
        restoreText(savedState, R.id.possession_right_view, "possession_right_view");
        //Yellow cards
        restoreText(savedState, R.id.ycards_left_view, "ycards_left_view");
        restoreText(savedState, R.id.ycards_right_view, "ycards_right_view");
        //Red cards
        restoreText(savedState, R.id.rcards_left_view, "rcards_left_view");
        restoreText(savedState, R.id.rcards_right_view, "rcards_right_view");

        //------------------------------Save the bars-------------------------------------------//
        restoreBar(savedState, R.id.score_bar_left, "score_bar_left");
        */
        restoreText(savedState, R.id.rcards_right_view, "savedText");
    }


    public void saveText(Bundle state, int id, String key) {
        //final TextView scoreLeftTextView = (TextView) findViewById(R.id.score_left_view);
        //CharSequence scoreLeftTextChars = scoreLeftTextView.getText(); //getText() Return the text that TextView is displaying as (CharSequence)
        //outState.putCharSequence("savedText", scoreLeftTextChars);
        //
        //outState.putCharSequence("savedText", ((TextView)findViewById(R.id.score_left_view)).getText());
        /*state.putCharSequence(key, ((TextView)findViewById(id)).getText());*/

        //Score
        state.putFloat("scoreLeft", scoreLeft);
        state.putFloat("scoreRight", scoreRight);
        //Total shots
        state.putFloat("tShotseLeft", tShotseLeft);
        state.putFloat("tShotseRight", tShotseRight);
        //Shots on target
        state.putFloat("targetShotseLeft", targetShotseLeft);
        state.putFloat("targetShotseRight", targetShotseRight);
        //Possession
        state.putFloat("possessionLeft", possessionLeft);
        state.putFloat("possessionRight", possessionRight);
        //Yellow cards
        state.putFloat("ycardsLeft", ycardsLeft);
        state.putFloat("ycardsRight", ycardsRight);
        //Red cards
        state.putFloat("rcardsLeft", rcardsLeft);
        state.putFloat("rcardsRight", rcardsRight);

    }

    public void restoreText(Bundle state, int id, String key) {
        //final TextView textBox = (TextView) findViewById(R.id.score_left_view);
        //CharSequence userText = savedState.getCharSequence("savedText");
        //textBox.setText(userText);
        //
        //((TextView) findViewById(R.id.score_left_view)).setText(savedState.getCharSequence("savedText"));
        /*((TextView) findViewById(id)).setText(state.getCharSequence(key));*/
        //
        //----------------------------------------------------------------------------------------------------
        //Score
        scoreLeft = state.getFloat("scoreLeft");
        scoreRight = state.getFloat("scoreRight");
        maxScore = scoreLeft + scoreRight;
        //Total shots
        tShotseLeft = state.getFloat("tShotseLeft", tShotseLeft);
        tShotseRight = state.getFloat("tShotseRight", tShotseRight);
        maxTshots = tShotseLeft + tShotseRight;
        //Shots on target
        targetShotseLeft = state.getFloat("targetShotseLeft", targetShotseLeft);
        targetShotseRight = state.getFloat("targetShotseRight", targetShotseRight);
        maxTargetshots = targetShotseLeft + targetShotseRight;
        //Possession
        possessionLeft = state.getFloat("possessionLeft", possessionLeft);
        possessionRight = state.getFloat("possessionRight", possessionRight);
        //Yellow cards
        ycardsLeft = state.getFloat("ycardsLeft", ycardsLeft);
        ycardsRight = state.getFloat("ycardsRight", ycardsRight);
        maxYcards = ycardsLeft + ycardsRight;
        //Red cards
        rcardsLeft = state.getFloat("rcardsLeft", rcardsLeft);
        rcardsRight = state.getFloat("rcardsRight", rcardsRight);
        maxRcards = rcardsLeft + rcardsRight;

        //----------------------------------------------------------------------------------------------------
        //Score
        displayText(R.id.score_left_view, Math.round(scoreLeft)+"");
        displayText(R.id.score_right_view, Math.round(scoreRight)+"");
        buttonPress(R.id.score_bar_left, R.id.score_design_bar_left, scoreLeft, R.id.score_bar_right, R.id.score_design_bar_right, scoreRight, maxScore, -18 + dpOffsetFromCenter);
        //Total shots
        displayText(R.id.tshots_left_view, Math.round(tShotseLeft)+"");
        displayText(R.id.tshots_right_view, Math.round(tShotseRight)+"");
        buttonPress(R.id.tshot_bar_left, R.id.tshots_design_bar_left, tShotseLeft, R.id.tshot_bar_right, R.id.tshots_design_bar_right, tShotseRight, maxTshots, -35 + dpOffsetFromCenter);
        //Shots on target
        displayText(R.id.targetshots_left_view, Math.round(targetShotseLeft)+"");
        displayText(R.id.targetshots_right_view, Math.round(targetShotseRight)+"");
        buttonPress(R.id.targetshot_bar_left, R.id.targetshots_design_bar_left, targetShotseLeft, R.id.targetshot_bar_right, R.id.targetshots_design_bar_right, targetShotseRight, maxTargetshots, -47 + dpOffsetFromCenter);
        //Possession
        displayText(R.id.possession_left_view, Math.round(possessionLeft*((float) 100/ maxPossession))+"%");
        displayText(R.id.possession_right_view, Math.round(possessionRight*((float) 100/ maxPossession))+"%");
        buttonPress(R.id.possession_bar_left, R.id.possession_design_bar_left, possessionLeft, R.id.possession_bar_right, R.id.possession_design_bar_right, possessionRight, maxPossession, -43 + dpOffsetFromCenter);
        //Yellow cards
        displayText(R.id.ycards_left_view, Math.round(ycardsLeft)+"");
        displayText(R.id.ycards_right_view, Math.round(ycardsRight)+"");
        buttonPress(R.id.ycards_bar_left, R.id.ycards_design_bar_left, ycardsLeft, R.id.ycards_bar_right, R.id.ycards_design_bar_right, ycardsRight, maxYcards, -40 + dpOffsetFromCenter);
        //Red cards
        displayText(R.id.rcards_left_view, Math.round(rcardsLeft)+"");
        displayText(R.id.rcards_right_view, Math.round(rcardsRight)+"");
        buttonPress(R.id.rcards_bar_left, R.id.rcards_design_bar_left, rcardsLeft, R.id.rcards_bar_right, R.id.rcards_design_bar_right, rcardsRight, maxRcards, -32 + dpOffsetFromCenter);
    }

    public void saveBar(Bundle state, int id, String key) {
        /*final View scoreLeftTextView = (View) findViewById(id);
        int scoreLeftTextChars = scoreLeftTextView.getWidth(); //getWidth Return the width of the your view in pixels as (int)
        state.putInt(key, scoreLeftTextChars);*/
    }

    public void restoreBar(Bundle state, int id, String key) {
        /*
        final View textBox = (View) findViewById(id);
        int userText = state.getInt(key);
        textBox.getLayoutParams().width = userText;*/
    }


    public float setScoreMargin(int id) {
        return Math.round(ConvertDpAndPixels.setPixelsToDp(getWidthId(id) / 2, this)) - dpOffsetFromCenter;
    }

    /**
     * Set the margins for a specified View
     *
     * @param view   specified View
     * @param left   left margin in pixels
     * @param top    top margin in pixels
     * @param right  right margin in pixels
     * @param bottom bottom margin in pixels
     */
    private void setMargins(View view, float left, float top, float right, float bottom) {
        if (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams p = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            p.setMargins(Math.round(left), Math.round(top), Math.round(right), Math.round(bottom));
            view.requestLayout();
        }
    }

    /**
     * Modify the width and margins of specified View
     *
     * @param idBar        id of the specified View
     * @param dpLeft       left margin in dp
     * @param dpTop        top margin in dp
     * @param dpRight      right margin in dp
     * @param dpBottom     bottom margin in dp
     * @param setWidthInDp desired width in dp
     */
    public void scoreBars(int idBar, float dpLeft, float dpTop, float dpRight, float dpBottom, float setWidthInDp) {
        //int b = (int)a; //typecasting float a to int
        //Math.round() return int so typecasting is redundant
        float leftPixels = Math.round(ConvertDpAndPixels.setDpToPixel(dpLeft, this));
        float topPixels = Math.round(ConvertDpAndPixels.setDpToPixel(dpTop, this));
        float rightPixels = Math.round(ConvertDpAndPixels.setDpToPixel(dpRight, this));
        float bottomPixels = Math.round(ConvertDpAndPixels.setDpToPixel(dpBottom, this));

        View scoreId = (View) findViewById(idBar);
        setMargins(scoreId, leftPixels, topPixels, rightPixels, bottomPixels); //pixels

        scoreId.getLayoutParams().width = Math.round(ConvertDpAndPixels.setDpToPixel(setWidthInDp, this));
        scoreId.requestLayout();
    }

    /**
     * Returns the width of a specified view
     *
     * @param idRef id of the specified view
     * @return the width of the specified view
     */
    public float getWidthId(int idRef) {
        View scoreRef = (View) findViewById(idRef);
        return scoreRef.getWidth(); //The width of your view, in pixels (int)
    }

    /**
     * Returns the height of a specified view
     *
     * @param idRef id of the specified view
     * @return the height of the specified view
     */
    public float getHeightId(int idRef) {
        View scoreRef = (View) findViewById(idRef);
        return scoreRef.getHeight(); //The height of your view, in pixels (int)
    }


    /**
     * Set the text of a specified TextView
     *
     * @param id     id of the specified view
     * @param numberAsString the number of goals, shots, etc
     */
    private void displayText(int id, String numberAsString) {
        TextView quantityTextView = (TextView) findViewById(id);
        quantityTextView.setText("" + numberAsString);
    }

    /**
     * Initial conditions when app is opened or reset
     */
    public void initCondition() {
        //----------------------------------------Init Scores------------------------------------------
        scoreLeft = 0;
        scoreRight = 0;
        maxScore = 1;
        //
        displayText(R.id.score_left_view, Math.round(scoreLeft)+"");
        displayText(R.id.score_right_view, Math.round(scoreRight)+"");

        //int bigBarIdLeft, int smallBarIdLeft, int varCounterLeft, int bigBarIdRight, int smallBarIdRight, int varCounterRight, int maxVar, int margin
        buttonPress(R.id.score_bar_left, R.id.score_design_bar_left, scoreLeft, R.id.score_bar_right, R.id.score_design_bar_right, scoreRight, maxScore, -18 + dpOffsetFromCenter);

        //----------------------------------------Init Total shots------------------------------------------
        tShotseLeft = 0;
        tShotseRight = 0;
        maxTshots = 1;
        //
        displayText(R.id.tshots_left_view, Math.round(tShotseLeft)+"");
        displayText(R.id.tshots_right_view, Math.round(tShotseRight)+"");

        //int bigBarIdLeft, int smallBarIdLeft, int varCounterLeft, int bigBarIdRight, int smallBarIdRight, int varCounterRight, int maxVar, int margin
        buttonPress(R.id.tshot_bar_left, R.id.tshots_design_bar_left, tShotseLeft, R.id.tshot_bar_right, R.id.tshots_design_bar_right, tShotseRight, maxTshots, -35 + dpOffsetFromCenter);

        //----------------------------------------Init Total shots------------------------------------------
        targetShotseLeft = 0;
        targetShotseRight = 0;
        maxTargetshots = 1;
        //
        displayText(R.id.targetshots_left_view, Math.round(targetShotseLeft)+"");
        displayText(R.id.targetshots_right_view, Math.round(targetShotseRight)+"");

        //int bigBarIdLeft, int smallBarIdLeft, int varCounterLeft, int bigBarIdRight, int smallBarIdRight, int varCounterRight, int maxVar, int margin
        buttonPress(R.id.targetshot_bar_left, R.id.targetshots_design_bar_left, targetShotseLeft, R.id.targetshot_bar_right, R.id.targetshots_design_bar_right, targetShotseRight, maxTargetshots, -47 + dpOffsetFromCenter);

        //----------------------------------------Init Possession------------------------------------------
        possessionLeft = 80;
        possessionRight = 80;
        //possessionRightZ = 80;
        maxPossession = maxWidthInDp;
        //
        displayText(R.id.possession_left_view, Math.round(possessionLeft*((float) 100/ maxPossession))+"%");
        displayText(R.id.possession_right_view, Math.round(possessionRight*((float) 100/ maxPossession))+"%");

        //int bigBarIdLeft, int smallBarIdLeft, int varCounterLeft, int bigBarIdRight, int smallBarIdRight, int varCounterRight, int maxVar, int margin
        buttonPress(R.id.possession_bar_left, R.id.possession_design_bar_left, possessionLeft, R.id.possession_bar_right, R.id.possession_design_bar_right, possessionRight, maxPossession, -43 + dpOffsetFromCenter);

        //----------------------------------------Init Yellow cards------------------------------------------
        ycardsLeft = 0;
        ycardsRight = 0;
        maxYcards = 1;
        //
        displayText(R.id.ycards_left_view, Math.round(ycardsLeft)+"");
        displayText(R.id.ycards_right_view, Math.round(ycardsRight)+"");

        //int bigBarIdLeft, int smallBarIdLeft, int varCounterLeft, int bigBarIdRight, int smallBarIdRight, int varCounterRight, int maxVar, int margin
        buttonPress(R.id.ycards_bar_left, R.id.ycards_design_bar_left, ycardsLeft, R.id.ycards_bar_right, R.id.ycards_design_bar_right, ycardsRight, maxYcards, -40 + dpOffsetFromCenter);

        //----------------------------------------Init Red cards------------------------------------------
        rcardsLeft = 0;
        rcardsRight = 0;
        maxRcards = 1;
        //
        displayText(R.id.rcards_left_view, Math.round(rcardsLeft)+"");
        displayText(R.id.rcards_right_view, Math.round(rcardsRight)+"");

        //int bigBarIdLeft, int smallBarIdLeft, int varCounterLeft, int bigBarIdRight, int smallBarIdRight, int varCounterRight, int maxVar, int margin
        buttonPress(R.id.rcards_bar_left, R.id.rcards_design_bar_left, rcardsLeft, R.id.rcards_bar_right, R.id.rcards_design_bar_right, rcardsRight, maxRcards, -32 + dpOffsetFromCenter);


    }//EOF initCondition

    /**
     * Reset button action
     *
     * @param view
     */
    public void resetButton(View view) {
        initCondition();
    }

    /**
     * Actions taken by pressing the score, total shots, etc buttons
     * @param bigBarIdLeft      id of the left counter bar
     * @param smallBarIdLeft    id of the default left bar
     * @param varCounterLeft    the counter for the left side
     * @param bigBarIdRight     id of the right counter bar
     * @param smallBarIdRight   id of the default right bar
     * @param varCounterRight   the counter for the right side
     * @param maxVar            the total counter
     * @param margin            the left and right margins for the bars
     */
    public void buttonPress(int bigBarIdLeft, int smallBarIdLeft, float varCounterLeft, int bigBarIdRight, int smallBarIdRight, float varCounterRight, float maxVar, float margin) {
        //Left bars
        (findViewById(bigBarIdLeft)).requestLayout();
        (findViewById(bigBarIdRight)).requestLayout();

        //left
        scoreBars(bigBarIdLeft, 0, 8, margin, 0, varCounterLeft * (maxWidthInDp / maxVar));
        scoreBars(smallBarIdLeft, 0, 10, 0, 0, maxWidthInDp - varCounterLeft * (maxWidthInDp / maxVar));
        //right
        scoreBars(bigBarIdRight, margin, 8, 0, 0, varCounterRight * (maxWidthInDp / maxVar));
        scoreBars(smallBarIdRight, 0, 10, 0, 0, maxWidthInDp - varCounterRight * (maxWidthInDp / maxVar));
    }

    //--------------------------------------------------------Score buttons-----------------------------------------------------------------
    public void scoreLeftButton(View view) {
        scoreLeft++;
        maxScore = scoreLeft + scoreRight;

        //int bigBarIdLeft, int smallBarIdLeft, int varCounterLeft, int bigBarIdRight, int smallBarIdRight, int varCounterRight, int maxVar, int margin
        buttonPress(R.id.score_bar_left, R.id.score_design_bar_left, scoreLeft, R.id.score_bar_right, R.id.score_design_bar_right, scoreRight, maxScore, -setScoreMargin(R.id.score_text_view));

        //
        displayText(R.id.score_left_view, Math.round(scoreLeft)+"");
    }

    public void scoreRightButton(View view) {
        scoreRight++;
        maxScore = scoreLeft + scoreRight;

        //int bigBarIdLeft, int smallBarIdLeft, int varCounterLeft, int bigBarIdRight, int smallBarIdRight, int varCounterRight, int maxVar, int margin
        buttonPress(R.id.score_bar_left, R.id.score_design_bar_left, scoreLeft, R.id.score_bar_right, R.id.score_design_bar_right, scoreRight, maxScore, -setScoreMargin(R.id.score_text_view));

        //
        displayText(R.id.score_right_view, Math.round(scoreRight)+"");
    }

    //--------------------------------------------------------Total shots buttons-----------------------------------------------------------------
    public void tShotsLeftButton(View view) {
        tShotseLeft++;
        maxTshots = tShotseLeft + tShotseRight;

        //int bigBarIdLeft, int smallBarIdLeft, int varCounterLeft, int bigBarIdRight, int smallBarIdRight, int varCounterRight, int maxVar, int margin
        buttonPress(R.id.tshot_bar_left, R.id.tshots_design_bar_left, tShotseLeft, R.id.tshot_bar_right, R.id.tshots_design_bar_right, tShotseRight, maxTshots, -setScoreMargin(R.id.tshots_text_view));

        //
        displayText(R.id.tshots_left_view, Math.round(tShotseLeft)+"");
    }

    public void tShotsRightButton(View view) {
        tShotseRight++;
        maxTshots = tShotseLeft + tShotseRight;

        //int bigBarIdLeft, int smallBarIdLeft, int varCounterLeft, int bigBarIdRight, int smallBarIdRight, int varCounterRight, int maxVar, int margin
        buttonPress(R.id.tshot_bar_left, R.id.tshots_design_bar_left, tShotseLeft, R.id.tshot_bar_right, R.id.tshots_design_bar_right, tShotseRight, maxTshots, -setScoreMargin(R.id.tshots_text_view));

        //
        displayText(R.id.tshots_right_view, Math.round(tShotseRight)+"");
    }

    //--------------------------------------------------------Shots on target buttons-----------------------------------------------------------------
    public void targetShotsLeftButton(View view) {
        if(targetShotseLeft<tShotseLeft) {
            targetShotseLeft++;
            maxTargetshots = targetShotseLeft + targetShotseRight;

            //int bigBarIdLeft, int smallBarIdLeft, int varCounterLeft, int bigBarIdRight, int smallBarIdRight, int varCounterRight, int maxVar, int margin
            buttonPress(R.id.targetshot_bar_left, R.id.targetshots_design_bar_left, targetShotseLeft, R.id.targetshot_bar_right, R.id.targetshots_design_bar_right, targetShotseRight, maxTargetshots, -setScoreMargin(R.id.targetshots_text_view));

            //
            displayText(R.id.targetshots_left_view, Math.round(targetShotseLeft)+"");
            //Log.i("sacaz", "on target: " + setScoreMargin(R.id.targetshots_text_view));

        } else {
            Toast.makeText(this, "The shots on target must be less or equal than Total shots!", Toast.LENGTH_SHORT).show();
        }
    }

    public void targetShotsRightButton(View view) {
        if(targetShotseRight<tShotseRight) {
            targetShotseRight++;
            maxTargetshots = targetShotseLeft + targetShotseRight;

            //int bigBarIdLeft, int smallBarIdLeft, int varCounterLeft, int bigBarIdRight, int smallBarIdRight, int varCounterRight, int maxVar, int margin
            buttonPress(R.id.targetshot_bar_left, R.id.targetshots_design_bar_left, targetShotseLeft, R.id.targetshot_bar_right, R.id.targetshots_design_bar_right, targetShotseRight, maxTargetshots, -setScoreMargin(R.id.targetshots_text_view));

            //
            displayText(R.id.targetshots_right_view, Math.round(targetShotseRight)+"");
        } else {
            Toast.makeText(this, "The shots on target must be less or equal than Total shots!", Toast.LENGTH_SHORT).show();
        }
    }

    //--------------------------------------------------------Score buttons-----------------------------------------------------------------
    public void possessionLeftButton(View view) {
        if(possessionLeft<maxPossession) {
            possessionLeft+= maxPossession/ (float) 100;
            possessionRight = maxPossession - possessionLeft;

            //int bigBarIdLeft, int smallBarIdLeft, int varCounterLeft, int bigBarIdRight, int smallBarIdRight, int varCounterRight, int maxVar, int margin
            buttonPress(R.id.possession_bar_left, R.id.possession_design_bar_left, possessionLeft, R.id.possession_bar_right, R.id.possession_design_bar_right, possessionRight, maxPossession, -setScoreMargin(R.id.possession_text_view));

            //
            displayText(R.id.possession_left_view, Math.round(possessionLeft*((float) 100/ maxPossession))+"%");
            displayText(R.id.possession_right_view, Math.round(possessionRight*((float) 100/ maxPossession))+"%");
            //Log.i("sacaz", "on target: " + setScoreMargin(R.id.possession_text_view));
        }
    }

    public void possessionRightButton(View view) {
        if(possessionRight<maxPossession) {
            possessionRight += maxPossession/ (float) 100;
            //possessionRightZ += 160/100; //the expression 160/100 is evaluated as int !!!
            possessionLeft = maxPossession - possessionRight;

            //int bigBarIdLeft, int smallBarIdLeft, int varCounterLeft, int bigBarIdRight, int smallBarIdRight, int varCounterRight, int maxVar, int margin
            buttonPress(R.id.possession_bar_left, R.id.possession_design_bar_left, possessionLeft, R.id.possession_bar_right, R.id.possession_design_bar_right, possessionRight, maxPossession, -setScoreMargin(R.id.possession_text_view));

            //
            displayText(R.id.possession_right_view, Math.round(possessionRight*((float) 100/ maxPossession))+"%");
            displayText(R.id.possession_left_view, Math.round(possessionLeft*((float) 100/ maxPossession))+"%");
            //Log.i("sacaz", "possessionRight: " + possessionRight);

        }
    }

    //--------------------------------------------------------Yellow cards buttons-----------------------------------------------------------------
    public void ycardsLeftButton(View view) {
        ycardsLeft++;
        maxYcards = ycardsLeft + ycardsRight;

        //int bigBarIdLeft, int smallBarIdLeft, int varCounterLeft, int bigBarIdRight, int smallBarIdRight, int varCounterRight, int maxVar, int margin
        buttonPress(R.id.ycards_bar_left, R.id.ycards_design_bar_left, ycardsLeft, R.id.ycards_bar_right, R.id.ycards_design_bar_right, ycardsRight, maxYcards, -setScoreMargin(R.id.ycards_text_view));

        //
        displayText(R.id.ycards_left_view, Math.round(ycardsLeft)+"");
        //Log.i("sacaz", "on target: " + setScoreMargin(R.id.ycards_text_view));
    }

    public void ycardsRightButton(View view) {
        ycardsRight++;
        maxYcards = ycardsLeft + ycardsRight;

        //int bigBarIdLeft, int smallBarIdLeft, int varCounterLeft, int bigBarIdRight, int smallBarIdRight, int varCounterRight, int maxVar, int margin
        buttonPress(R.id.ycards_bar_left, R.id.ycards_design_bar_left, ycardsLeft, R.id.ycards_bar_right, R.id.ycards_design_bar_right, ycardsRight, maxYcards, -setScoreMargin(R.id.ycards_text_view));

        //
        displayText(R.id.ycards_right_view, Math.round(ycardsRight)+"");
    }

    //--------------------------------------------------------Red cards buttons-----------------------------------------------------------------
    public void rcardsLeftButton(View view) {
        rcardsLeft++;
        maxRcards = rcardsLeft + rcardsRight;

        //int bigBarIdLeft, int smallBarIdLeft, int varCounterLeft, int bigBarIdRight, int smallBarIdRight, int varCounterRight, int maxVar, int margin
        buttonPress(R.id.rcards_bar_left, R.id.rcards_design_bar_left, rcardsLeft, R.id.rcards_bar_right, R.id.rcards_design_bar_right, rcardsRight, maxRcards, -setScoreMargin(R.id.rcards_text_view));

        //
        displayText(R.id.rcards_left_view, Math.round(rcardsLeft)+"");
        Log.i("sacaz", "on target: " + setScoreMargin(R.id.rcards_text_view));
    }

    public void rcardsRightButton(View view) {
        rcardsRight++;
        maxRcards = rcardsLeft + rcardsRight;

        //int bigBarIdLeft, int smallBarIdLeft, int varCounterLeft, int bigBarIdRight, int smallBarIdRight, int varCounterRight, int maxVar, int margin
        buttonPress(R.id.rcards_bar_left, R.id.rcards_design_bar_left, rcardsLeft, R.id.rcards_bar_right, R.id.rcards_design_bar_right, rcardsRight, maxRcards, -setScoreMargin(R.id.rcards_text_view));

        //
        displayText(R.id.rcards_right_view, Math.round(rcardsRight)+"");
    }


}//EOF File
