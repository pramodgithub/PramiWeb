import { useEffect } from 'react';

import { useDispatch, useSelector } from 'react-redux';
import { Grid } from '@mui/material';
import PropTypes from 'prop-types';
import axios from 'axios';

import { setProducts } from '../../../redux/actions/productActions';
import ShopProductCard from './ProductCard';

ProductList.propTypes = {
  products: PropTypes.array.isRequired,
};

export default function ProductList({ products, ...other }) {
  const productstore = useSelector((state) => state);
  const dispatch = useDispatch();

  const fetchProducts = async () => {
    const response = await axios.get('http://127.0.0.1:3001/products').catch((error) => console.error(error));
    console.log(response.data);
    dispatch(setProducts(response.data));
  };

  useEffect(() => {
    fetchProducts();
  }, []);
  console.log(productstore);
  return (
    <Grid container spacing={3} {...other}>
      {products.map((product) => (
        <Grid key={product.id} item xs={12} sm={6} md={3}>
          <ShopProductCard product={product} />
        </Grid>
      ))}
    </Grid>
  );
}
