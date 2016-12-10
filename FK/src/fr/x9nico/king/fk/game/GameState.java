package fr.x9nico.king.fk.game;

/**
 * Class create a goal State of the Game.
 * @author KingRider
 */
public enum GameState {
	
	LOBBY(true), TIME(false), PVP(false), FINISH(false);
	
	// Conditions
	private static GameState current;
	private boolean canJoin;
	
	GameState(boolean b) {
		canJoin = b;
	}
	
	// PEUT REJOINDRE ?
	public boolean canJoin() {
		return canJoin;
	}
	
	// SET STATE
	public static void setState(GameState state) {
		current = state;
	}
	
	// IS STATE
	public static boolean isState(GameState state) {
		return current == state;
	}
	
	// GET STATE
	public static GameState getState() {
		return current;
	}

}
