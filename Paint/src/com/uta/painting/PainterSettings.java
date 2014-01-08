package com.uta.painting;

import android.content.pm.ActivityInfo;
/** 
* @author Team
* @version 1.0
*/
public class PainterSettings {
	public BrushPreset preset = null;
	public String lastPicture = null;
	public boolean forceOpenFile = false;
	public int orientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;
}