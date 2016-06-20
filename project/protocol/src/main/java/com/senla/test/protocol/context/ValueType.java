package com.senla.test.protocol.context;

public enum ValueType {
	INTEGER {
		@Override
		public boolean checkValue(Object object) {
			try {
				Integer.parseInt(object.toString());
				return true;
			} catch (Exception e){
				return false;
			}
		}
	}, 
	BOOLEAN {
		
		@Override
		public boolean checkValue(Object object) {
			return Boolean.TRUE.toString().equals(object) || Boolean.FALSE.toString().equals(object);
		}
	}, 
	STRING {
		@Override
		public boolean checkValue(Object object) {
			return true;
		}
	};
	
	public abstract boolean checkValue(Object object);
}	
