import { Helmet } from 'react-helmet-async';
import { useEffect } from 'react';

import axios from 'axios';
import { useParams } from 'react-router-dom';
import { useDispatch, useSelector } from 'react-redux';

// @mui
import { Container, Typography } from '@mui/material';
// components
import { selectedproduct } from '../redux/actions/productActions';
import { NewProductCard, ProductCartWidget } from '../sections/@dashboard/products';

const PRODUCT_COLOR = ['#00AB55', '#000000', '#FFFFFF', '#FFC0CB', '#FF4842', '#1890FF', '#94D82D', '#FFC107'];
const product = {
  id: '1tre546',
  cover: `/assets/images/products/product_1.jpg`,
  name: 'Nike Air Force 1 NDESTRUKT',
  price: 24,
  priceSale: 10,
  colors: PRODUCT_COLOR,
  status: 'Sale',
};

const Product = () => {
  const product = useSelector((state) => state.product);
  const { id } = useParams();
  const dispatch = useDispatch();
  //  console.log(`product: ${JSON.stringify(product)}`);
  const fetchProduct = async () => {
    const response = await axios.get(`http://127.0.0.1:3001/productById/${id}`).catch((error) => console.error(error));

    dispatch(selectedproduct(response.data));
  };

  useEffect(() => {
    if (id && id !== '') fetchProduct();
  }, [id]);

  return (
    <>
      <Helmet>
        <title> Dashboard: Product | Minimal UI </title>
      </Helmet>

      <Container>
        <NewProductCard product={product} />
        <ProductCartWidget />
      </Container>
    </>
  );
};

export default Product;
