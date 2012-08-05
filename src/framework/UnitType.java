package framework;

public enum UnitType {
	Marshal, General, Colonel, Major, Captain, Lieutenant, Sergeant, Miner, Scout, Spy, Bomb, Flag, Empty, Unknown;

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
			return "";
		}
		return "%";
	}
}
