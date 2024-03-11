import { useEffect, useState } from "react";
import { useStore } from "../data/store";

const useTexts = (componentName) => {
  const { jsonData, fetchData } = useStore();
  const [texts, setTexts] = useState(null);

  useEffect(() => {
    const getTexts = () => {
      if (jsonData && componentName) {
        setTexts(jsonData[componentName] || null);
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
