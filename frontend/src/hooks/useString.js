import { useEffect, useState } from "react";
import { useStore } from "../data/store";

const useTexts = (componentName) => {
  const { jsonData, fetchData } = useStore();
  const [texts, setTexts] = useState({});

  useEffect(() => {
    const getTexts = () => {
      if (jsonData && componentName) {
        console.log(jsonData)
        setTexts(jsonData[componentName] || {});
      }
    };

    if (!jsonData) {
      fetchData();
    } else {
      getTexts();
    }
  }, [jsonData, fetchData, componentName]);

  return {
    texts,
  };
};

export default useTexts;
