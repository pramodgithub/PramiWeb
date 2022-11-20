import { combineReducers } from 'redux';
import { productReducer, selectedProductReducer, shoppingCartReducer } from './productReducer';

const reducers = combineReducers({
  allProducts: productReducer,
  product: selectedProductReducer,
  cartProducts: shoppingCartReducer,
});

export default reducers;
