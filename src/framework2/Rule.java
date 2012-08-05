package framework2;

import framework.StrategoGame;

public interface Rule {
	public RuleAnswer getAnswer(int columnFrom, int rowFrom, int columnTo, int rowTo, StrategoGame game);
}
