package framework2;

import framework.StrategoGame;

public interface Rule {
	public RuleAnswer getAnswer(int columnFrom, int rowFrom, int columnTo, int rowTo, World world);
	public RuleAnswer getAnswer(Location from, Location to, World world);
}
