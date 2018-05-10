package com.github.oxo42.stateless4j;

import java.util.ArrayList;
import java.util.List;

import com.github.oxo42.stateless4j.delegates.Action1;
import com.github.oxo42.stateless4j.transitions.Transition;

public class OnTransitionedEvent<S, T> {
	List<Action1<Transition<S, T>>> onTransitioned = new ArrayList<Action1<Transition<S, T>>>();
    //final List<Func<Transition, Task>> _onTransitionedAsync = new List<Func<Transition, Task>>();

    public void Invoke(Transition<S, T> transition)
    {
    	for (Action1<Transition<S, T>> action1 : onTransitioned) {
    		action1.doIt(transition);
		}        
    }

    public void Register(Action1<Transition<S, T>> action)
    {
    	if(!onTransitioned.contains(action))
    	{
    		onTransitioned.add(action);
    	}
    }

//    public void Register(Func<Transition, Task> action)
//    {
//        _onTransitionedAsync.Add(action);
//    }
}
