package com.lpoot4g02.game.States;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Stack;

/**
 * Created by Bruno on 03-05-2017.
 */

public class GameStateManager
{
    private Stack<State> states;


    public GameStateManager()
    {
        states = new Stack<State>();
    }

    public void push(State state)
    {
        states.push(state);
    }

    public void pop()
    {
        states.pop();
    }

    public void set(State state)
    {
        states.pop();
        states.push(state);
    }


    //Following two functions to update and render the top of the stack

    public void update(float dt)  //dt (delta) -> time between the two renders
    {
        states.peek().update(dt);
    }

    public void render(SpriteBatch sb)
    {
        states.peek().render(sb);
    }
}
