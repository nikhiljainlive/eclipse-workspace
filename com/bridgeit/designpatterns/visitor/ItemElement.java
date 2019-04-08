package com.bridgeit.designpatterns.visitor;

public interface ItemElement {

	public int accept(ShoppingCartVisitor visitor);
}