package framework2;

import java.io.Serializable;

import org.newdawn.slick.Color;

public enum PlayerColors implements Serializable {
	Red,Blue,None;
	
	public Color getColor(){
		switch(this){
		case Red: return Color.red;
		case Blue: return Color.blue;
		case None: return Color.white;
		}
		return Color.black;
	}
	
	public String toString(){
		switch (this) {
		case Red: return "Red";
		case Blue: return "Blue";
		case None: return "None";
		}
		return ";(";
	}
}
