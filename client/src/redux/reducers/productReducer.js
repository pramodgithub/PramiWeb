import { ActionTypes } from '../constants/action-types';

const initialState = {
  products: [],
};

const cartInitialState = {
  cartProducts: localStorage.getItem( 'SelectedOption' ) || [],
  
};
export const productReducer = (state = initialState, { type, payload }) => {
  switch (type) {
    case ActionTypes.SET_PRODUCTS:
      return { ...state, products: payload };

    default:
      return state;
  }
};

export const selectedProductReducer = (state = cartInitialState, { type, payload }) => {
  switch (type) {
    case ActionTypes.SELECTED_PRODUCT:
      return { ...state, ...payload };
    default:
      return state;
  }
};
export const shoppingCartReducer = (state = cartInitialState, { type, payload }) => {
  switch (type) {
    case ActionTypes.PRODUCT_ADDED:
      localStorage.setItem( 'SelectedOption', [payload] );
      console.log(`cartInitialState : ${JSON.stringify(cartInitialState)}`);
      console.log(`payload : ${JSON.stringify(payload)}`);
      console.log(`State : ${JSON.stringify(state)}`);
      return { ...state, cartProducts: [...state.cartProducts, payload] };
    default:
      return state;
  }
};
