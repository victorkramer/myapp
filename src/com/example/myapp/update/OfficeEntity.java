package com.example.myapp.update;

import android.content.ContextWrapper;

public class OfficeEntity extends Entity {
	
	public OfficeEntity(ContextWrapper cw){
		mUpdater = new OfficeUpdater(cw);
	}
}
