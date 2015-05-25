package repo;

import java.util.ArrayList;

import dao.WaiterDaoImpl;
import entity.Waiter;

public class WaiterRepo
{
	private ArrayList<Waiter> waiter;
	private WaiterDaoImpl dao;
	
	public WaiterRepo()
	{
		waiter = new ArrayList<Waiter>();
		
		populate();
	}
	
	public void addWaiter( Waiter w )
	{
		dao.insert( w );
		waiter.add( w );
	}
	
	public Waiter getWaiter( int index )
	{
		return waiter.get( index );
	}
	
	public Waiter getWaiterByName( String name )
	{
		Waiter w = dao.findByName( name );
		
		if( w instanceof Waiter )
		{
			return w;
		}
		
		return null;
	}
	
	public Waiter getWaiterByCpf( String cpf )
	{
		for( Waiter w: waiter )
		{
			if( w.getCpf().equalsIgnoreCase( cpf ) )
			{
				return w;
			}
		}
		
		return null;
	}
	
	@Override
	public String toString()
	{
		StringBuilder result = new StringBuilder();
		
		for( Waiter w: waiter )
		{
			result.append( w.toString() );
		}
		
		return result.toString();
	}
	
	private void populate()
	{
		this.addWaiter( new Waiter( "Felipe", "026", 1000.00) );
		this.addWaiter( new Waiter( "Vivian", "025", 1000.00) );
		this.addWaiter( new Waiter( "Eduardo", "024", 1000.00) );
	}
}
