package framework2;

import java.io.Serializable;

public enum UnitType implements Serializable{
	Marshal, General, Colonel, Major, Captain, Lieutenant, Sergeant, Miner, Scout, Spy, Bomb, Flag, Empty, Unknown;

	public int getAmount() {
		switch (this) {
		case Marshal:
			return 1;
		case General:
			return 1;
		case Colonel:
			return 2;
		case Major:
			return 3;
		case Captain:
			return 4;
		case Lieutenant:
			return 4;
		case Sergeant:
			return 4;
		case Miner:
			return 5;
		case Scout:
			return 8;
		case Spy:
			return 1;
		case Bomb:
			return 6;
		case Flag:
			return 1;
		case Unknown:
			return 0;
		case Empty:
			return 0;
		}
		return 0;
	}

	public String toString() {
		switch (this) {
		case Marshal:
			return "1";
		case General:
			return "2";
		case Colonel:
			return "3";
		case Major:
			return "4";
		case Captain:
			return "5";
		case Lieutenant:
			return "6";
		case Sergeant:
			return "7";
		case Miner:
			return "8";
		case Scout:
			return "9";
		case Spy:
			return "S";
		case Bomb:
			return "B";
		case Flag:
			return "F";
		case Unknown:
			return "#";
		case Empty:
			return "E";
		}
		return "%";
	}
}
