% 3/27 Tuesday: Class cancled 

% 3/30 Thursday 

% 1. concurrent program in procedural languages
%		mutex, syncronized methods, shared memory 

% 2. how functional programming helps with concurrency 
%	- mutable state is bad here
%	- side effects and concurrency do not mix 

% 3. concurrency vs. parallelism 
%concurrent: single cpu with shared processing time 
%parallelism: truely parallelism, multiple cpus / processors, something like super computing 

% 4. banefits of parallelism: 
%		performace better, scalability, fault tolerance, clarity

%5. Erlang's solution: message passing
%	def: message passing is a programming style in which a program consiists of independent entities (agents) that intereact by sending messages asynchronously

%	Why this is useful: non-blocking code, net working, distributed computing, web stuff 

%	what languages have you seen that use message passing? 
%		objective - c
%		Smalltalk 
%		Both are orentiented 

sending and recieving messages: 
Pid: process id

self(): get your own process id 

fundamentaly nonderterministic 

eg.sendexamples code // kind of low to run it because the random

% how to test a function:
% c(sendexamples).
% sendexamples:main().

Actors: 
def: an actor is a process that communicated with other processes by sending messages 
ie. an Erlang process, used as clients, servers, nodes in distributed systems 

two types: stateless (state does not change)
		   stateful 
		   
% Example: computatinal server - mathserver.erl

-module(mathserver).
-export([start/0, compute/3]).

start()->
	spawn(fun mserver/0).
		
mserver()->
	recieve{pid, compute, Funs, Arg}->
		pid!{ok, accumulate(lists:reverse(Funs),Arg)},
		mserver()
	end.
% ; - used for different cases 	
% . - used for end of function definition

accumulate([], Acc)->
	Acc;
accumulate([F|Fs], Acc)->
	accumulate(Fs, math:F(Acc)).
	
compute(P, Funs, val)->
	P! {self(), compute, Funs, val}.
	recieve
		{ok, Res}->
			Res
	end.
	
% ========= how to call mathserver===========
c(mathserver).
P = mathserver:start().
% sin=cos=1.0
mathserver:compute(P, [sin, cos], 1.0). 
% ==========================================

% write a stateless server to compute fractional integers 
% use test modules: factorialserver_test 

% stateless server:
-module(stateless1).
-export([start/2, rpc/2]).

start(Name, Mod)->
	register(Name, 
			spawn(fun() -> loop(Name, Mod)
				  end)).
				  
rcp(Name, Request)->
	Name! {self(), Request},
	recieve
		{Name, Response}->Response
	end.
	
% check notes 
loop(Name, Mod)->
	recieve
		{From, Request}->
				Response = Mod:handle(Request),
				
	
% another factorial server:

-module (factorial).
-export([fact/a, mult_server/0]).

fact(0)->1;
fact(N)->
	Me = self(),
	P1 = spawn(fun mult_server/0),
	P2 = spawn(fun mult_server/0),
	P1 ! {Me, N, N div 2 +1},
	P2 ! {Me, N div 2, 1}, 
	recieve 
		V1 -> 
			recieve V2 ->
				V1*V2
			end
	end.

mult_server()->
	recieve
		{Pid, N, M}->
			Pid ! multiply_from_to(N,M,1)
		end.
		
multiply_from_to(N,M,Acc) ->
	if N<M -> Acc;
		true-> multiply_from_to(N-1, M, N*Acc)
	end. 
	
% generalized version of factorial server: 
% factorialserverinclass 
	
	


