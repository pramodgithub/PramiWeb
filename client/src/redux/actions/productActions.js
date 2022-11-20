import { ActionTypes } from '../constants/action-types';

export const setProducts = (products) => ({
  type: ActionTypes.SET_PRODUCTS,
  payload: products,
});

export const selectedproduct = (product) => ({
  type: ActionTypes.SELECTED_PRODUCT,
  payload: product,
});

export const addToCart = (product) => ({
  type: ActionTypes.PRODUCT_ADDED,
  payload: product,
});
