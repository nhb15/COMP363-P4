package edu.luc.etl.cs313.android.simplestopwatch.model.state;

import edu.luc.etl.cs313.android.simplestopwatch.R;
import android.media.AudioManager;
import android.media.ToneGenerator;

class AlarmState implements StopwatchState {

    public AlarmState(final StopwatchSMStateView sm) {
        this.sm = sm;
    }

    private final StopwatchSMStateView sm;

    /**
     * On button click, Stop clock/beeping and move to stopped state
     */
    @Override
    public void onStartStop() {
        //sm.actionStart();
        sm.actionStop();
        sm.toStoppedState();
    }


    @Override
    /**
     * beep on every tick of the clock
     */
    public void onTick() {
        beep();
//        while(true) {
//            beep();
//        }
        //throw new UnsupportedOperationException("onTick");

    }


    /**
    *No need to update view in "AlarmState"
     */

    @Override
    public void updateView() {
        throw new UnsupportedOperationException("updateView");
        //sm.updateUIRuntime();
    }




    /**
    Added to strings.xml file
     */

    @Override
    public int getId() {
        return R.string.ALARM;
    }












/**
    // Re-used from ReadyToRunSate
    // could be pulled out for multiple classes to use
 */
    public void beep(){
        /**
         * Taking thoughts from here:
         * https://developer.android.com/reference/android/media/ToneGenerator
         * and here
         * https://stackoverflow.com/questions/29509010/how-to-play-a-short-beep-to-android-phones-loudspeaker-programmatically
         * Below is a tone that should sound for 150 milliseconds, I still want to test it and maybe toy with the
         * actual tone
         */
        ToneGenerator transitionTone = new ToneGenerator(AudioManager.STREAM_MUSIC, 100);
        transitionTone.startTone(ToneGenerator.TONE_CDMA_PIP,150);

        /**We tried "toolkit beep" but it didn't work
         *
         * ADD TO INTERFACE

         ToneGenerator toneGen1 = new ToneGenerator(AudioManager.STREAM_MUSIC, 100);
         toneGen1.startTone(ToneGenerator.TONE_CDMA_PIP, 150);

         * COULD ALSO TRY
         *
         * / send the tone to the "alarm" stream (classic beeps go there) with 50% volume
         ToneGenerator toneG = new ToneGenerator(AudioManager.STREAM_ALARM, 50);
         if (val >= taux_max) {
         taux_text.setTextColor(warnning_col);
         toneG.startTone(ToneGenerator.TONE_CDMA_ALERT_CALL_GUARD, 200); // 200 is duration in ms
         }
         */
    }

}
